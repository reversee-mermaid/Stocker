import { setErrMessage } from '/res/js/module/common.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'

const { file, nm } = form

update_btn.addEventListener('click', async function() {
	let valid
	
	valid = nm.value || file.value
	if(!valid) {
		location.reload()
		return
	}

	valid = await submit().then(({code}) => process(code))
	if(!valid) return

	location.reload()
})

function submit() {
	let formData = new FormData()

	if(nm.value) {
		formData.append('nm', nm.value)
	}

	if(file.value) {
		formData.append('file', file.files[0])
	}

	return getResponseJSON('/user/profile', getRequestInit(formData))
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