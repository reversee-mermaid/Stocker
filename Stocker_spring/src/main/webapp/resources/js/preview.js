import { setErrMessage } from '/res/js/module/common.js'
import { isImageFile } from '/res/js/module/file.js'

const { file:fileField } = form

fileField.addEventListener('click', () => setErrMessage(''))
fileField.addEventListener('change', function() {
	let valid
	
	valid = this.value
	if(!valid) {
		removePreview()
		return
	}
	
	const file = this.files[0]
	valid = isImageFile(file)
	if(!valid) {
		removePreview()
		this.focus()
		this.value = null
		setErrMessage('The file is unsupported or invalid format !!')
		return
	}
	
	setPreview(file)
})

export function setPreview(file) {
	let img = preview.querySelector('img')
	
	if (!img) {
		img = document.createElement('img')
		preview.appendChild(img)
	}
	
	if(file.constructor == File) {
		img.src = URL.createObjectURL(file)	
	} else {
		img.src = file
	}
}

function removePreview() {
	const img = preview.querySelector('img')
	if(img) {
		preview.removeChild(img)
	}
}