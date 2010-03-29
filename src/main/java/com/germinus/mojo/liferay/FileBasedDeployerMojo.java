package com.germinus.mojo.liferay;

import org.apache.maven.plugin.AbstractMojo;
import org.codehaus.plexus.util.FileUtils;

import java.io.IOException;
import java.io.File;

/**
 * Goal which deploys a portlet in Liferay Portal
 *
 * @goal hot-deploy
 * @execute phase="package"
 */
public class FileBasedDeployerMojo extends AbstractMojo {

    /**
     * Final artifact file name
     *
     * @parameter expression="${project.build.directory}/${project.build.finalName}.${project.artifact.artifactHandler.extension}"
     * @required
     * @readonly
     */
    private File sourceFile;

    /**
     * Final artifact file name
     *
     * @parameter expression="${deployDirectory}"
     * @required
     */
    private String deployDirectory;

    /**
     * Final artifact file name
     *
     * @parameter expression="${project.artifactId}.${project.artifact.artifactHandler.extension}"
     * @required
     * @readonly
     */
    private String deployFileName;

    public void execute() {
        getLog().info("Deploying artifact to: " + deployDirectory);
        try {
            FileUtils.copyFile(sourceFile, getDestinationFile());
        } catch (IOException e) {
            getLog().error("Cannot copy file to execute directory", e);
        }
    }

    private File getDestinationFile() {
        return new File(deployDirectory + "/" + deployFileName);
    }
}
