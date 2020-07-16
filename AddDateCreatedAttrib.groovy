// @CacheScriptContent(true)
import groovy.swing.SwingBuilder
import java.awt.FlowLayout as FL
import javax.swing.BoxLayout as BXL
import javax.swing.JFrame
import java.util.Date

// Init
def s = new SwingBuilder()
s.setVariable('myDialog-properties',[:])
def vars = s.variables

// Get Date and Time right now
Date today = Calendar.getInstance().getTime()

// Init panel. Code shamefully plagarized from Quinbus' awesome script: https://sourceforge.net/p/freeplane/discussion/758437/thread/1695d722/#32b2 
def dial = s.dialog(title:'EditDate', id:'myDialog', minimumSize: [300,50], modal:true, locationRelativeTo:ui.frame, owner:ui.frame, defaultCloseOperation:JFrame.DISPOSE_ON_CLOSE, pack:true, show:true) {
	
	panel() {
	boxLayout(axis:BXL.Y_AXIS)
	// 2 buttons
	panel(alignmentX:0f) {
		flowLayout(alignment:FL.LEFT)
		button(action: action(name: 'yyMMdd', mnemonic: '1',
							  closure: {vars.date1 = true; dispose()}))
		button(action: action(name: 'yyMMdd HH:mm', mnemonic: '2',
							  closure: {vars.date2 = true; dispose()}))
	}
    }
	
}

// Add Attribs
if (vars.date1){

node["DateCreated"] = format(today, "yyMMdd")

} else if (vars.date2) {
	
	node["DateCreated"] = format(today, "yyMMdd HH:mm")
	
}
