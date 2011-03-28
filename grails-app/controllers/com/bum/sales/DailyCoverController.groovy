package com.bum.sales

class DailyCoverController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index = {
        redirect(action: "list", params: params)
    }

    def list = {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        [dailyCoverInstanceList: DailyCover.list(params), dailyCoverInstanceTotal: DailyCover.count()]
    }

    def create = {
        def dailyCoverInstance = new DailyCover()
        dailyCoverInstance.properties = params
        return [dailyCoverInstance: dailyCoverInstance]
    }

    def save = {
        def dailyCoverInstance = new DailyCover(params)
        if (dailyCoverInstance.save(flush: true)) {
            flash.message = "${message(code: 'default.created.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), dailyCoverInstance.id])}"
            redirect(action: "show", id: dailyCoverInstance.id)
        }
        else {
            render(view: "create", model: [dailyCoverInstance: dailyCoverInstance])
        }
    }

    def show = {
        def dailyCoverInstance = DailyCover.get(params.id)
        if (!dailyCoverInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), params.id])}"
            redirect(action: "list")
        }
        else {
            [dailyCoverInstance: dailyCoverInstance]
        }
    }

    def edit = {
        def dailyCoverInstance = DailyCover.get(params.id)
        if (!dailyCoverInstance) {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), params.id])}"
            redirect(action: "list")
        }
        else {
            return [dailyCoverInstance: dailyCoverInstance]
        }
    }

    def update = {
        def dailyCoverInstance = DailyCover.get(params.id)
        if (dailyCoverInstance) {
            if (params.version) {
                def version = params.version.toLong()
                if (dailyCoverInstance.version > version) {
                    
                    dailyCoverInstance.errors.rejectValue("version", "default.optimistic.locking.failure", [message(code: 'dailyCover.label', default: 'DailyCover')] as Object[], "Another user has updated this DailyCover while you were editing")
                    render(view: "edit", model: [dailyCoverInstance: dailyCoverInstance])
                    return
                }
            }
            dailyCoverInstance.properties = params
            if (!dailyCoverInstance.hasErrors() && dailyCoverInstance.save(flush: true)) {
                flash.message = "${message(code: 'default.updated.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), dailyCoverInstance.id])}"
                redirect(action: "show", id: dailyCoverInstance.id)
            }
            else {
                render(view: "edit", model: [dailyCoverInstance: dailyCoverInstance])
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), params.id])}"
            redirect(action: "list")
        }
    }

    def delete = {
        def dailyCoverInstance = DailyCover.get(params.id)
        if (dailyCoverInstance) {
            try {
                dailyCoverInstance.delete(flush: true)
                flash.message = "${message(code: 'default.deleted.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), params.id])}"
                redirect(action: "list")
            }
            catch (org.springframework.dao.DataIntegrityViolationException e) {
                flash.message = "${message(code: 'default.not.deleted.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), params.id])}"
                redirect(action: "show", id: params.id)
            }
        }
        else {
            flash.message = "${message(code: 'default.not.found.message', args: [message(code: 'dailyCover.label', default: 'DailyCover'), params.id])}"
            redirect(action: "list")
        }
    }
}
