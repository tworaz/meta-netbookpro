FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
PRINC = "2"

SRC_URI_append = " \
    file://Xserver.netbookpro.patch \
    file://Xserver.fbset-path.patch \
    file://${P}-default-xmodmap-fixes.patch \
    file://${P}-add-netbookpro-xmodmap.patch \
    "
