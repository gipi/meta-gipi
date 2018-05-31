DESCRIPTION = "I am the first recipe"
PR = "r1"

LICENSE = "GPL-2+"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"

DEPENDS += "qtbase"
# qtdeclarative qtquickcontrols2"

require recipes-qt/qt5/qt5.inc
inherit update-alternatives

# https://www.yoctoproject.org/docs/1.8/bitbake-user-manual/bitbake-user-manual.html#local-file-fetcher
#FILESPATH = "/opt/QT5/Test"
FILESEXTRAPATHS_prepend := "/opt/QT5/Test/:${THISDIR}/${P}:"

SRC_URI = "file://Test.pro \
    file://main.cpp        \
    file://mainwindow.cpp  \
    file://mainwindow.h  \
    file://mainwindow.ui \
    file://kiosk-session"

S = "${WORKDIR}"

ALTERNATIVE_${PN} = "x-session-manager"
ALTERNATIVE_TARGET[x-session-manager] = "${bindir}/kiosk-session"
ALTERNATIVE_PRIORITY = "100"

do_install() {
    install -d ${D}${bindir}
    cp -R --no-dereference --preserve=mode,links ${B}/Test ${D}${bindir}
	install -m 0755 ${S}/kiosk-session ${D}/${bindir}
}
