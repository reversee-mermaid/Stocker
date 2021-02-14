import { setErrMessage } from '/res/js/module/common.js'
import { checkValidityAll } from '/res/js/module/form.js'
import { setPreloader, unsetPreloader } from '/res/js/module/preloader.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'
import { isImageFile, setPreview, removePreview } from '/res/js/module/file.js'

const { title, caption, tags, file } = form

upload_btn.addEventListener('click', async function() {
	setErrMessage('')
	
	let valid
	
	valid = checkValidityAll([title, caption, file])
	if(!valid) return
	
	valid = checkValidityForTags(tags)
	if(!valid) return
	
	setPreloader()
	const { id, code } = await submit().then(json => json)
	unsetPreloader()
	
	valid = process(code)
	if(!valid) return
	
	location.href = `/article/detail?id=${id}`
})

async function submit() {
		const formData = new FormData(form)
		return getResponseJSON('/article/upload', getRequestInit(formData))
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

function checkValidityForTags(checkboxList) {
	const checked = Array.from(checkboxList).find(el => el.checked)
	
	if(!checked) {
		setErrMessage('You must select at least one tag !!')
		return false
	}
	
	return true
}

file.addEventListener('click', () => setErrMessage(''))
file.addEventListener('change', function() {
	let valid
	
	valid = this.value
	if(!valid) {
		removePreview(preview)
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
})