package com.santt4na.rapidinner_delivery.helpers;

import com.santt4na.rapidinner_delivery.entities.Admin;

public class RemoveAdmin {
  public void removeAdmin(Admin admin) {
    if (admin != null) {
      admin.setUser(null);
    }
  }
}
