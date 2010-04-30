package com.djimenez.example.spring.mvc.service.role;

import java.util.List;

import com.djimenez.example.spring.mvc.model.LabelValue;

/**
 * Business Service Interface to talk to persistence layer and retrieve values
 * for drop-down choice lists.
 * 
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupRoleManager {

  /**
   * Retrieves all possible roles from persistence layer
   * 
   * @return List of LabelValue objects
   */
  List<LabelValue> getAllRoles();
}
