import { setErrMessage } from '/res/js/module/common.js'
import { isImageFile, setPreview, removePreview } from '/res/js/module/file.js'

const { file:fileField } = form

fileField.addEventListener('click', () => setErrMessage(''))
fileField.addEventListener('change', function() {
	let valid
	
	valid = this.value
	if(!valid) {
		removePreview(preview)
		return
	}
	
	const file = this.files[0]
	valid = isImageFile(file)
	if(!valid) {
		removePreview(preview)
		this.focus()
		this.value = null
		setErrMessage('The file is unsupported or invalid format !!')
		return
	}
	
	setPreview(preview, file)
})