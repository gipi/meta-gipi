DESCRIPTION = "PCB Scanner"
PR = "r1"

LICENSE = "GPL-2"

LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

SRCREV = "8363d7e7bd91385cd711139651bedc980658f0e1"
SRC_URI = "git://github.com/gipi/anet-scanner.git;branch=gui"

S = "${WORKDIR}/git/gui/"

DEPENDS += "qtbase qtmultimedia"

require recipes-qt/qt5/qt5.inc

TARGET_CFLAGS += "-DGUI_DEBUG"

# Why here we have to specify explicitely the build/gui path?
do_install() {
    install -d ${D}${bindir}
    cp -R --no-dereference --preserve=mode,links ${B}/build/gui ${D}${bindir}
}
