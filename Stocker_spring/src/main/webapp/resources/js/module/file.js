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