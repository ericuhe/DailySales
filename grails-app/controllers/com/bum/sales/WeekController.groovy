package com.bum.sales

class WeekController {

	def weekUtilsService
	
    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [weekInstanceList: Week.list(params), weekInstanceTotal: Week.count()]
    }

    def create = {
        def weekInstance = new Week()
        weekInstance.properties = params
        return [weekInstance: weekInstance]
    }

    def save = {
        def weekInstance = new Week(params)
        if (weekInstance.save(flush: true)) {
			weekUtilsService.createDefaultReceipts(weekInstance)
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'week.label', default: 'Week'), weekInstance.id])}"
            redirect(action: "show", id: weekInstance.id)
        }
        else {
            render(view: "create", model: [weekInstance: weekInstance])
        }
    }

    def show = {
        def weekInstance = Week.get(params.id)
        if (!weekInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'week.label', default: 'Week'), params.id])}"
            redirect(action: "list")
        }
        else {
            [weekInstance: weekInstance]
        }
    }

    def edit = {
        def weekInstance = Week.get(params.id)
        if (!weekInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'week.label', default: 'Week'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [weekInstance: weekInstance]
        }
    }

    def update = {
        def weekInstance = Week.get(params.id)
        if (weekInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (weekInstance.version > version) {
                    
                    weekInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'week.label', default: 'Week')] as Object[], "Another user has updated this Week while you were editing")
                    render(view: "edit", model: [weekInstance: weekInstance])
                    return
                }
            }
            weekInstance.properties = params
            if (!weekInstance.hasErrors() && weekInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'week.label', default: 'Week'), weekInstance.id])}"
                redirect(action: "show", id: weekInstance.id)
            }
            else {
                render(view: "edit", model: [weekInstance: weekInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'week.label', default: 'Week'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def weekInstance = Week.get(params.id)
        if (weekInstance) {
            try {
                weekInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'week.label', default: 'Week'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'week.label', default: 'Week'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'week.label', default: 'Week'), params.id])}"
            redirect(action: "list")
        }
    }
}
