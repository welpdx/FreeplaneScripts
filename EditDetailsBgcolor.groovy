// @ExecutionModes({ON_SINGLE_NODE})
// Functions gratefully retrieved from https://www.freeplane.org/wiki/index.php/Scripting:_text_editing#Inserts_an_inline_image_into_node_text_or_details

// Remove html, body, p tags. This preserves Rich Text
def RemoveHtmlTags(text) {
    def strippedText = text.replaceAll('<(html|head|body|p)>', '')
    strippedText = strippedText.replaceAll('</(html|head|body|p)>', '')
    strippedText = strippedText.replaceAll('\n', '')
    strippedText = strippedText.replaceAll('^\\s*', '')
    return strippedText
}


// Change the body tag to include a background color
def AddHtmlTags(text) { return '<html><head><body bgcolor="#def28d"><p>' + text + '</p></body></head></html>' }
// Remove tags
var nodeDetailTxt = RemoveHtmlTags(node.detailsText)
// New html content for node detail with bgcolor
var nNodeDetailTxt = AddHtmlTags(nodeDetailTxt)
// Replace node.details with new content
node.details = nNodeDetailTxt