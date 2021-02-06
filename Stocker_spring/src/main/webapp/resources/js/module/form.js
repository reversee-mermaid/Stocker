export function checkValidityAll(fieldList) {
	const invalidField = fieldList.find(field => !field.checkValidity())
	
	if(!invalidField) return true
	
	invalidField.focus()
	invalidField.reportValidity()
	return false
}