require xserver-kdrive.inc

DEPENDS += "libxkbfile libxcalibrate font-util pixman"

RDEPENDS_${PN} += "xkeyboard-config"

PR = "r2"

SRC_URI = "${XORG_MIRROR}/individual/xserver/xorg-server-${PV}.tar.bz2 \
    file://crosscompile.patch \
    file://fix_open_max_preprocessor_error.patch \
    file://macro_tweak.patch \
    file://xepson-support.patch \
    file://keyboard-resume-workaround.patch \
    file://disable-apm.patch \
    file://no-serial-probing.patch \
    file://hide-cursor-and-ppm-root.patch \
    file://fbdev_xrandr_ioctl.patch \
    "

SRC_URI[md5sum] = "8796fff441e5435ee36a72579008af24"
SRC_URI[sha256sum] = "fa415decf02027ca278b06254ccfbcceba2a83c2741405257ebf749da4a73cf2"
LIC_FILES_CHKSUM = "file://COPYING;md5=74df27b6254cc88d2799b5f4f5949c00"

S = "${WORKDIR}/xorg-server-${PV}"
