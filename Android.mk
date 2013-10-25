#wpan utilties and TI ST user space manager
ifneq ($(BOARD_HAVE_BLUETOOTH_TI),)
include $(call first-makefiles-under,$(call my-dir))
endif
