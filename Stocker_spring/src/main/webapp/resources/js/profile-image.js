import { setErrMessage } from '/res/js/module/common.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'
import { isImageFile, setPreview, removePreview } from '/res/js/module/file.js'

const { file } = form

file.addEventListener('click', () => setErrMessage(''))
file.addEventListener('change', async function() {
	let valid
	
	valid = this.value
	if(!valid) {
		removePreview(preview)
		await submit()
		return
	}
	
	const _file = this.files[0]
	valid = isImageFile(_file)
	if(!valid) {
		removePreview(preview)
		this.focus()
		this.value = null
		setErrMessage('The file is unsupported or invalid format !!')
		return
	}
	
	setPreview(preview, _file)
	valid = await submit().then(({code}) => process(code))
	if(!valid) return
})

function submit() {
	const formData = new FormData()
	const _file = file.files[0]
	if(_file) {
		formData.append('file', _file)
	}
	
	return getResponseJSON('/user/profile-image', getRequestInit(formData))
}

function process(code) {
	let message
	
	if(code == 1) return true
	if(code == 0) {
		message = 'A server has error occurred ..!'
	}
	
	setErrMessage(message)
	return false
}