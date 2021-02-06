import { setErrMessage } from '/res/js/module/common.js'
import { checkValidityAll } from '/res/js/module/form.js'

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
	
	const { id, code } = await submit().then(json => json)
	valid = process(code)
	if(!valid) return 
	
	location.href = `/article/detail?id=${id}`
})

async function submit() {
		const formData = new FormData(form)
		
		const param = new FormData()
		param.append('title', title.value)
		param.append('caption', caption.value)
		param.append('file', file.files[0])
		param.append('tagList', formData.getAll('tags').map(tag_pk => parseInt(tag_pk)))
		
		return fetch('/article/upload', {
        method: 'POST',
        body: formData
    }).then(res => res.json())
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
