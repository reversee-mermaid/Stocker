import { setErrMessage } from '/res/js/module/common.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'

const { nm } = form

update_btn.addEventListener('click', async function() {
	let valid
	
	valid = nm.value
	if(!valid) {
		location.reload()
		return
	}

	valid = await submitInfo().then(({code}) => process(code))
	if(!valid) return

	location.reload()
})

function submitInfo() {
	const param = {
		nm: nm.value
	}
	return getResponseJSON('/user/profile', getRequestInit(param))
}

function process(code) {
	let message

	if(code == 1) return true
	if(code == 0) {
		message = 'A server has error occurred ..!'
	} else if(code == -1) {
		message = 'You need to login first !!'
	}

	setErrMessage(message)
	return false
}