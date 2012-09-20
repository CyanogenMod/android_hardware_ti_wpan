ifeq ($(BOARD_WPAN_DEVICE),true)
#wpan utilties and TI ST user space manager
include $(call first-makefiles-under,$(call my-dir))
endif