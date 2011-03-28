package com.bum.sales

class Week {

	Date startDate
	Date endDate
	Set dailyReceipts
	Set dailyDiscounts
	Set dailyCovers
	Set dailyIncomes


	static hasMany = [dailyReceipts : DailyReceipt]//, dailyDiscounts : DailyDiscount, dailyCovers : DailyCover, dailyIncomes : DailyIncome ]

	static constraints = {
		startDate(nullable: false)
		endDate(nullable:false)
		dailyReceipts(nullable:true)
		dailyDiscounts(nullable:true)
		dailyCovers(nullable:true)
		dailyIncomes(nullable:true)
	}
	static fetchMode = 	[dailyReceipts:'eager', dailyDiscounts:'eager', dailyCovers:'eager', dailyIncomes:'eager']

	void setEndDate() {
		endDate = startDate.plus(6)
	}

	static beforeInsert = { setEndDate() }
	static beforeUpdate = { setEndDate() }
	
}
