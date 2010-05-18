package com.djimenez.example.spring.mvc.web.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.djimenez.example.spring.mvc.constants.Constants;

/**
 * Controller class to upload Files.
 * <p>
 * <a href="FileUploadFormController.java.html"><i>View Source</i></a>
 * </p>
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public class FileUploadController extends BaseFormController {

  public FileUploadController() {
    setCommandName("fileUpload");
    setCommandClass(FileUpload.class);
  }

  @Override
  public ModelAndView onSubmit(final HttpServletRequest request,
    final HttpServletResponse response, final Object command,
    final BindException errors) throws Exception {
    final FileUpload fileUpload = (FileUpload) command;

    // validate a file was entered
    if (fileUpload.getFile().length == 0) {
      final Object[] args =
        new Object[] { getText("uploadForm.file", request.getLocale()) };
      errors.rejectValue("file", "errors.required", args, "File");

      return showForm(request, response, errors);
    }

    final MultipartHttpServletRequest multipartRequest =
      (MultipartHttpServletRequest) request;
    final CommonsMultipartFile file =
      (CommonsMultipartFile) multipartRequest.getFile("file");

    // the directory to upload to
    final String uploadDir =
      getServletContext().getRealPath("/resources") + "/"
        + request.getRemoteUser() + "/";

    // Create the directory if it doesn't exist
    final File dirPath = new File(uploadDir);

    if (!dirPath.exists()) {
      dirPath.mkdirs();
    }

    // retrieve the file data
    final InputStream stream = file.getInputStream();

    // write the file to the file specified
    final OutputStream bos =
      new FileOutputStream(uploadDir + file.getOriginalFilename());
    int bytesRead;
    final byte[] buffer = new byte[8192];

    while ((bytesRead = stream.read(buffer, 0, 8192)) != -1) {
      bos.write(buffer, 0, bytesRead);
    }

    bos.close();

    // close the stream
    stream.close();

    // place the data into the request for retrieval on next page
    request.setAttribute("friendlyName", fileUpload.getName());
    request.setAttribute("fileName", file.getOriginalFilename());
    request.setAttribute("contentType", file.getContentType());
    request.setAttribute("size", file.getSize() + " bytes");
    request.setAttribute("location", dirPath.getAbsolutePath()
      + Constants.FILE_SEP + file.getOriginalFilename());

    final String link =
      request.getContextPath() + "/resources" + "/" + request.getRemoteUser()
        + "/";
    request.setAttribute("link", link + file.getOriginalFilename());

    return new ModelAndView(getSuccessView());
  }

  @Override
  public ModelAndView processFormSubmission(final HttpServletRequest request,
    final HttpServletResponse response, final Object command,
    final BindException errors) throws Exception {
    if (request.getParameter("cancel") != null) {
      return new ModelAndView(getCancelView());
    }

    return super.processFormSubmission(request, response, command, errors);
  }
}
