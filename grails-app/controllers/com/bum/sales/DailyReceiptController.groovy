package com.bum.sales

class DailyReceiptController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dailyReceiptInstanceList: DailyReceipt.list(params), dailyReceiptInstanceTotal: DailyReceipt.count()]
    }

    def create = {
        def dailyReceiptInstance = new DailyReceipt()
        dailyReceiptInstance.properties = params
        return [dailyReceiptInstance: dailyReceiptInstance]
    }

    def save = {
        def dailyReceiptInstance = new DailyReceipt(params)
        if (dailyReceiptInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), dailyReceiptInstance.id])}"
            redirect(action: "show", id: dailyReceiptInstance.id)
        }
        else {
            render(view: "create", model: [dailyReceiptInstance: dailyReceiptInstance])
        }
    }

    def show = {
        def dailyReceiptInstance = DailyReceipt.get(params.id)
        if (!dailyReceiptInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dailyReceiptInstance: dailyReceiptInstance]
        }
    }

    def edit = {
        def dailyReceiptInstance = DailyReceipt.get(params.id)
        if (!dailyReceiptInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dailyReceiptInstance: dailyReceiptInstance]
        }
    }

    def update = {
        def dailyReceiptInstance = DailyReceipt.get(params.id)
        if (dailyReceiptInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dailyReceiptInstance.version > version) {
                    
                    dailyReceiptInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dailyReceipt.label', default: 'DailyReceipt')] as Object[], "Another user has updated this DailyReceipt while you were editing")
                    render(view: "edit", model: [dailyReceiptInstance: dailyReceiptInstance])
                    return
                }
            }
            dailyReceiptInstance.properties = params
            if (!dailyReceiptInstance.hasErrors() && dailyReceiptInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), dailyReceiptInstance.id])}"
                redirect(action: "show", id: dailyReceiptInstance.id)
            }
            else {
                render(view: "edit", model: [dailyReceiptInstance: dailyReceiptInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dailyReceiptInstance = DailyReceipt.get(params.id)
        if (dailyReceiptInstance) {
            try {
                dailyReceiptInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyReceipt.label', default: 'DailyReceipt'), params.id])}"
            redirect(action: "list")
        }
    }
}
