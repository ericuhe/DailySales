package com.bum.sales

class WeekUtilsService {

    static transactional = true

    def serviceMethod() {

    }
	
	def createDefaultReceipts(Week weekInstance) {
		def defaultMonday = DailyReceipt.findByWeek(weekInstance)
		if(defaultMonday) return
		(weekInstance.startDate..weekInstance.endDate).each { dow ->
			def tempDailyReceipt = new DailyReceipt(week:weekInstance, date:dow)
			weekInstance.addToDailyReceipts(tempDailyReceipt).save()
		} 
	}
}
