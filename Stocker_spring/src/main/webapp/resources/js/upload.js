import { setErrMessage } from '/res/js/module/common.js'
import { checkValidityAll } from '/res/js/module/form.js'
import { setPreloader, unsetPreloader } from '/res/js/module/preloader.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'

const { title, caption, tags, file } = form

tags.forEach(tag => {
	tag.addEventListener('change', toggleLabelHighlight)
})

function toggleLabelHighlight() {
	const label = this.labels[0]
	label.classList.toggle('checked')
}

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
