import { setErrMessage } from '/res/js/module/common.js'
import { checkValidityAll } from '/res/js/module/form.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'

const { email, pw } = form

login_btn.addEventListener('click', async function() {
	let valid

	valid = checkValidityAll([email, pw])
	if (!valid) return

	valid = await submit().then(({ code }) => process(code))
	if (!valid) return

	location.href = '/home'
})

function submit() {
	const param = {
		email: email.value,
		pw: pw.value,
	}

	return getResponseJSON('/user/login', getRequestInit(param))
}

function process(code) {
	let message

	if (code == 1) return true
	if (code == 0) {
		message = 'A server error has occurred ..!'
	} else if (code == -1) {
		message = 'Email does not exist !!'
		email.focus()
	} else if (code == -2) {
		message = 'Wrong password !!'
		pw.focus()
	}

	setErrMessage(message)
	return false
}