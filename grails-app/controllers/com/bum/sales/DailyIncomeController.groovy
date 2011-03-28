package com.bum.sales

class DailyIncomeController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dailyIncomeInstanceList: DailyIncome.list(params), dailyIncomeInstanceTotal: DailyIncome.count()]
    }

    def create = {
        def dailyIncomeInstance = new DailyIncome()
        dailyIncomeInstance.properties = params
        return [dailyIncomeInstance: dailyIncomeInstance]
    }

    def save = {
        def dailyIncomeInstance = new DailyIncome(params)
        if (dailyIncomeInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), dailyIncomeInstance.id])}"
            redirect(action: "show", id: dailyIncomeInstance.id)
        }
        else {
            render(view: "create", model: [dailyIncomeInstance: dailyIncomeInstance])
        }
    }

    def show = {
        def dailyIncomeInstance = DailyIncome.get(params.id)
        if (!dailyIncomeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dailyIncomeInstance: dailyIncomeInstance]
        }
    }

    def edit = {
        def dailyIncomeInstance = DailyIncome.get(params.id)
        if (!dailyIncomeInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dailyIncomeInstance: dailyIncomeInstance]
        }
    }

    def update = {
        def dailyIncomeInstance = DailyIncome.get(params.id)
        if (dailyIncomeInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dailyIncomeInstance.version > version) {
                    
                    dailyIncomeInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dailyIncome.label', default: 'DailyIncome')] as Object[], "Another user has updated this DailyIncome while you were editing")
                    render(view: "edit", model: [dailyIncomeInstance: dailyIncomeInstance])
                    return
                }
            }
            dailyIncomeInstance.properties = params
            if (!dailyIncomeInstance.hasErrors() && dailyIncomeInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), dailyIncomeInstance.id])}"
                redirect(action: "show", id: dailyIncomeInstance.id)
            }
            else {
                render(view: "edit", model: [dailyIncomeInstance: dailyIncomeInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dailyIncomeInstance = DailyIncome.get(params.id)
        if (dailyIncomeInstance) {
            try {
                dailyIncomeInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyIncome.label', default: 'DailyIncome'), params.id])}"
            redirect(action: "list")
        }
    }
}
