import { setErrMessage } from '/res/js/module/common.js'
import { checkValidityAll } from '/res/js/module/form.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'

const { nm } = form

update_btn.addEventListener('click', async function() {
	let valid
	
	valid = checkValidityAll([nm])
	if(!valid) return
	
	valid = await submit().then(({code}) => process(code))
	if(!valid) return
	
	location.reload()
})

async function submit() {
	const param = {
		nm: nm.value
	}
	return getResponseJSON('/user/update', getRequestInit(param))
}

function process(code) {
	let message
	
	if(code == 1) return true
	if(code == 0) {
		message = 'A server error has occurred ..!'
	}
	
	setErrMessage(message)
	return false
}