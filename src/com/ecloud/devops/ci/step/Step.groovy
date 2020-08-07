package com.ecloud.devops.ci.step

import com.ecloud.devops.ci.context.Context


interface Step extends Serializable {
  void execute(Context context)
}