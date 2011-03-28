package com.bum.sales

class DailyReceipt {
	
	Week week
	Date date
	String weather
	String comments
	BigDecimal food = 0.00
	BigDecimal beer = 0.00
	BigDecimal wine = 0.00
	BigDecimal liquor = 0.00
	BigDecimal totalSales = 0.00
	BigDecimal mealsTax = 0.00
	BigDecimal giftCertificates = 0.00
	BigDecimal totalReceipts = 0.00
	
	static belongsTo = Week
	
    static constraints = {
		weather(nullable: true, maxSize :64)
		comments(nullable:true, maxsize:128)
		date(nullable:false)
		food(nullable:true, scale:4)
		beer(nullable:true, scale:4)
		wine(nullable:true, scale:4)
		liquor(nullable:true, scale:4)
		totalSales(nullable:true, scale:4)
		mealsTax(nullable:true, scale:4)
		giftCertificates(nullable:true, scale:4)
		totalReceipts(nullable:true, scale:4)
    }
	
	BigDecimal getTotalSales() {
		BigDecimal total = 0.00
		total.setScale 4
		total = this.food + this.beer + this.wine + this.liquor
	}
	
	BigDecimal getTotalReceipts() {
		BigDecimal total = 0.00
		total.setScale 4
		total = getTotalSales() + mealsTax + giftCertificates 
	}
	
}
