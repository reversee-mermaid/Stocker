export function isImageFile({type}) {
	if(!type.includes('image/')) return false
	
	switch (type.replace('image/', '')) {
		case 'png':
		case 'jpg':
		case 'jpeg':
			return true
		default:
			return false
	}
}

export function setPreview(container, file) {
	let img = container.querySelector('img')
	
	if (!img) {
		img = document.createElement('img')
		container.appendChild(img)
	}
	
	if(file.constructor == File) {
		img.src = URL.createObjectURL(file)	
	} else {
		img.src = file
	}
}

export function removePreview(container) {
	const img = container.querySelector('img')
	if(img) {
		container.removeChild(img)
	}
}