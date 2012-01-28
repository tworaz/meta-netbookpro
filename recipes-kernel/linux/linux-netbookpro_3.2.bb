SECTION = "kernel"
DESCRIPTION = "Linux kernel for Psion Teklogix NetBook Pro"
LICENSE = "GPLv2"

DEPENDS="boost-img-native boost-bootcode"

PV = "3.2.2"
PR = "r0"

SRC_URI = "git://github.com/tworaz/linux.git;protocol=git;branch=v${PV}-nbpro"
SRCREV = "2c471b17301a4f5e4519df28dfac1329ce3642b5"

ARCH = "arm"
COMPATIBLE_HOST = "arm.*-linux"
COMPATIBLE_MACHINE = "netbookpro"

S = "${WORKDIR}/git"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

inherit kernel

NBKPRO_IMG_NAME ?= "nBkProOs.img"
NBKPRO_IMG_DESCR ?= "NetBook Pro Linux ${PV}"

PACKAGES += "kernel-image-raw"

FILES_kernel-image = "/${KERNEL_IMAGEDEST}/${NBKPRO_IMG_NAME}"
FILES_kernel-image-raw = "/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}*"

do_configure_prepend() {
	install -m 0644 ${S}/arch/arm/configs/netbookpro_defconfig ${S}/.config
}

kernel_do_compile_append() {
	boost-img create \
              -k arch/${ARCH}/boot/Image \
              -b ${DEPLOY_DIR_IMAGE}/bcode-latest.bin \
              -o ${NBKPRO_IMG_NAME} \
              -d "${NBKPRO_IMG_DESCR}" \
              -z || die "Failed to create boost img"
}

kernel_do_install_append() {
    install -m 0644 ${NBKPRO_IMG_NAME} ${D}/${KERNEL_IMAGEDEST}
}

kernel_do_deploy_append() {
	install -m 0644 ${S}/${NBKPRO_IMG_NAME} ${DEPLOYDIR}/${NBKPRO_IMG_NAME}_${KERNEL_VERSION}
}

pkg_postinst_kernel-base () {
}

pkg_postrm_kernel-base () {
}
