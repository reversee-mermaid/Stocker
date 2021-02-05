export function checkValidityAll(fieldList) {
	const invalidField = fieldList.find(field => !field.checkValidity())
	
	if(!invalidField) return true
	
	invalidField.focus()
	invalidField.reportValidity()
	return false
}

export function setErrMessage(message) {
	const messageField = document.querySelector('.err_message')
	messageField.innerText = message
}