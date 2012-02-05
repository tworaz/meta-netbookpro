require xserver-kdrive.inc

DEPENDS += "libxkbfile libxcalibrate font-util pixman"

RDEPENDS_${PN} += "xkeyboard-config"

PR = "r0"

SRCREV = "944e1e0209bc1b366ce80a670c1f9fa044e80571"
SRC_URI = "git://github.com/tworaz/xserver.git;protocol=git;branch=xepson-${PV} \
    file://crosscompile.patch \
    file://fix_open_max_preprocessor_error.patch \
    file://macro_tweak.patch \
    file://keyboard-resume-workaround.patch \
    file://disable-apm.patch \
    file://no-serial-probing.patch \
    file://hide-cursor-and-ppm-root.patch \
    file://fbdev_xrandr_ioctl.patch \
    "

LIC_FILES_CHKSUM = "file://COPYING;md5=74df27b6254cc88d2799b5f4f5949c00"

S = "${WORKDIR}/git"
