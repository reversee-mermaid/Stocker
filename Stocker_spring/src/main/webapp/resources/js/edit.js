import { getParam, setErrMessage } from '/res/js/module/common.js'
import { checkValidityAll } from '/res/js/module/form.js'
import { setPreloader, unsetPreloader } from '/res/js/module/preloader.js'
import { getResponseJSON, getRequestInit } from '/res/js/module/request.js'
import { setPreview } from '/res/js/module/file.js'

const { title, caption, tags, file } = form

edit_btn.addEventListener('click', async function() {
	setErrMessage('')
	
	let valid
	
	valid = checkValidityAll([title, caption])
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
		formData.set('id', getParam('id'))
		return getResponseJSON('/article/edit', getRequestInit(formData))
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

async function init() {
	const id = getParam('id')
	const uri = `/article/detail/thumb?id=${id}`
	const {article} = await getResponseJSON(uri, null).then(json => json)
	
	title.value = article.title
	caption.value = article.caption ? article.caption : null
	
	article.tagList.forEach(tag => {
		tags[tag.id - 1].checked = true
	})
	
	form.removeChild(file)
	
	const filePath = `/res/image/${article.author_id}/${article.file_nm}`
	const container = document.querySelector('#preview')
	setPreview(container, filePath)
}

init()