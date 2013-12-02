#
#
# Copyright 2001-2011 Texas Instruments, Inc. - http://www.ti.com/
#
#  Licensed under the Apache License, Version 2.0 (the "License");
#  you may not use this file except in compliance with the License.
#  You may obtain a copy of the License at
#
#    http://www.apache.org/licenses/LICENSE-2.0
#
#  Unless required by applicable law or agreed to in writing, software
#  distributed under the License is distributed on an "AS IS" BASIS,
#  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
#  See the License for the specific language governing permissions and
#  limitations under the License.
#
#TO Check whether we need any flags to enable FM
ifneq ($(CFG_FM_SERVICE_TI),false)
  include hardware/ti/wpan/tools/FM/FmRxApp/Android.mk
  include hardware/ti/wpan/tools/FM/FmTxApp/Android.mk
  include hardware/ti/wpan/tools/FM/service/Android.mk
  include hardware/ti/wpan/tools/FM/FmRadioIf/Android.mk
  include hardware/ti/wpan/tools/FM/service/src/jni/Android.mk
endif
