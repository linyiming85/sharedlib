package com.ecloud.step

import com.ecloud.context.Context

interface Step extends Serializable {
  void execute(Context context)
}