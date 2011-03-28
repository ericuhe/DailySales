package com.bum.sales

class DailyDiscountController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dailyDiscountInstanceList: DailyDiscount.list(params), dailyDiscountInstanceTotal: DailyDiscount.count()]
    }

    def create = {
        def dailyDiscountInstance = new DailyDiscount()
        dailyDiscountInstance.properties = params
        return [dailyDiscountInstance: dailyDiscountInstance]
    }

    def save = {
        def dailyDiscountInstance = new DailyDiscount(params)
        if (dailyDiscountInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), dailyDiscountInstance.id])}"
            redirect(action: "show", id: dailyDiscountInstance.id)
        }
        else {
            render(view: "create", model: [dailyDiscountInstance: dailyDiscountInstance])
        }
    }

    def show = {
        def dailyDiscountInstance = DailyDiscount.get(params.id)
        if (!dailyDiscountInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dailyDiscountInstance: dailyDiscountInstance]
        }
    }

    def edit = {
        def dailyDiscountInstance = DailyDiscount.get(params.id)
        if (!dailyDiscountInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dailyDiscountInstance: dailyDiscountInstance]
        }
    }

    def update = {
        def dailyDiscountInstance = DailyDiscount.get(params.id)
        if (dailyDiscountInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dailyDiscountInstance.version > version) {
                    
                    dailyDiscountInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dailyDiscount.label', default: 'DailyDiscount')] as Object[], "Another user has updated this DailyDiscount while you were editing")
                    render(view: "edit", model: [dailyDiscountInstance: dailyDiscountInstance])
                    return
                }
            }
            dailyDiscountInstance.properties = params
            if (!dailyDiscountInstance.hasErrors() && dailyDiscountInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), dailyDiscountInstance.id])}"
                redirect(action: "show", id: dailyDiscountInstance.id)
            }
            else {
                render(view: "edit", model: [dailyDiscountInstance: dailyDiscountInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dailyDiscountInstance = DailyDiscount.get(params.id)
        if (dailyDiscountInstance) {
            try {
                dailyDiscountInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyDiscount.label', default: 'DailyDiscount'), params.id])}"
            redirect(action: "list")
        }
    }
}
