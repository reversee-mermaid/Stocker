import { setErrMessage } from '/res/js/module/common.js'
import { checkValidityAll } from '/res/js/module/form.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'

const { email, nm, pw, pw_repeat } = form

signup_btn.addEventListener('click', async function() {
	let valid
	
	valid = checkValidityAll([email, nm, pw, pw_repeat])
	if(!valid) return
	
	valid = pw.value == pw_repeat.value
	if(!valid) return process(-2)
	
	valid = await submit().then(({code}) => process(code))
	if(!valid) return
	
	location.href = '/user/login'
})

function submit() {
	const param = {
		email: email.value,
		nm: nm.value,
		pw: pw.value,
	}
	
	return getResponseJSON('/user/signup', getRequestInit(param))
}

function process(code) {
	let message

	if(code == 1) return true
	if(code == 0) {
		message = 'A server error has occurred ..!'
	} else if(code == -1) {
		message = 'Email is already in use !!'
		email.focus()
	} else if(code == -2) {
		message = 'Password mismatch !!'
		pw.focus()
	}
	
	setErrMessage(message)
	return false
}
