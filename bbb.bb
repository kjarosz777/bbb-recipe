
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

# FILESEXTRAPATHS:append := ":/home/kjarosz/projects/"

# S = "${WORKDIR}"

# SRC_URI = "file://aaa.tar.gz"

SRC_URI = "git://github.com/kjarosz777/aaa;protocol=https;branch=master"
# SRCREV = "7be0ecee143a291a5c6483426e235eb5b3e09a96"
SRCREV = "${AUTOREV}"

S = "${WORKDIR}/git"

DEPENDS:append = " update-rc.d-native"

do_install () {
	install -d ${D}${sysconfdir}/init.d
	install -m 0755    ${WORKDIR}/aaa_run.sh	${D}${sysconfdir}/init.d/

	update-rc.d -r ${D} aaa_run.sh start 99 5 .
}
