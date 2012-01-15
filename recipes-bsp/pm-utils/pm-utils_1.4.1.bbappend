FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
PRINC = "1"

SRC_URI += " file://hook-blacklist"

do_install_append () {
	install -d "${D}/${sysconfdir}/pm/config.d"
	install -m 0644 ${WORKDIR}/hook-blacklist "${D}/${sysconfdir}/pm/config.d"
}
