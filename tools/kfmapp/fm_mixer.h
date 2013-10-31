/*
 *  FM Mixer values for TI's WILINK chip.
 *
 *  Copyright (C) 2012 Texas Instruments
 *
 *  This program is free software; you can redistribute it and/or modify
 *  it under the terms of the GNU General Public License version 2 as
 *  published by the Free Software Foundation.
 *
 *  This program is distributed in the hope that it will be useful,
 *  but WITHOUT ANY WARRANTY; without even the implied warranty of
 *  MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *  GNU General Public License for more details.
 *
 *  You should have received a copy of the GNU General Public License
 *  along with this program; if not, write to the Free Software
 *  Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
 *
 */
#define CAPTURE_PREAMPLIFIER_VOLUME    68
#define CAPTURE_VOLUME                 69
#define MUX_UL11                       58
#define MUX_UL10                       59
#define DL1_MIXER_MULTIMEDIA           55
#define DL1_CAPTURE_PLAYBACK_VOLUME    9
#define DL1_PDM_SWITCH                 36
#define DL1_MIXER_CAPTURE              54
#define AMIC_UL_VOLUME                 29

#ifdef ENABLE_OMAP5_FM
/* OMAP5 mixer values */
#define ANALOG_RIGHT_CAPTURE_ROUTE     85
#define ANALOG_LEFT_CAPTURE_ROUTE      86

#define HEADSET_RIGHT_PLAYBACK         81
#define HEADSET_LEFT_PLAYBACK          82
#else
/* OMAP4 mixer values */
#define ANALOG_RIGHT_CAPTURE_ROUTE     76
#define ANALOG_LEFT_CAPTURE_ROUTE      77

#define HEADSET_RIGHT_PLAYBACK         72
#define HEADSET_LEFT_PLAYBACK          73
#endif

#define AUX_FM_RIGHT                   2  /* Analog FM Input fed to Phoenix */
#define AUX_FM_LEFT                    2  /* Analog FM Input fed to Phoenix */
#define MMEXT_LEFT                     9  /* Digital FM input fed to ABE via MM_EXT_IN*/
#define MMEXT_RIGHT                    10 /* Digital FM input fed to ABE via MM_EXT_IN*/
#define AMIC0                          11
#define AMIC1                          12

#define ON                             1
#define OFF                            0
