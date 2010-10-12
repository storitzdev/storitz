package storitz

import com.studentsonly.grails.plugins.uiperformance.taglib.AbstractTaglib

/**
 * Generates a &lt;script type='text/javascript' src='...'&gt;&lt;/script&gt; tag.
 * <p/>
 * The only required attribute is 'src', which is the relative path of the js
 * file without the .js extension ('/js/foo.js' would specify src='foo', '/js/foo/bar/z.js'
 * would specify src='foo/bar/z').
 * <p/>
 * 'plugin' is an optional attribute used if the source is in a plugin. 
 * <p/>
 * &lt;p:javascript src='foo' /&gt;
 * would generate this output:
 * &lt;script type='text/javascript' src='/js/foo.js'&gt;&lt;/script&gt;
 *
 * @author <a href='mailto:burt@burtbeckwith.com'>Burt Beckwith</a>
 */
class JavascriptTagLib extends AbstractTaglib {

	static namespace = 'storitz'

	// dependency injection
	def jsTagPostProcessor

	/**
	 * Generates the tag.
	 */
	def javascriptLink = { attrs ->

		if (!attrs.src) {
			throwTagError("Tag [javascript] is missing required attribute [src]")
		}

		String link = generateRelativePath('js', attrs.remove('src'), '.js',
				attrs.remove('plugin'), attrs.remove('absolute'))

        link = "'$link'"
		if (jsTagPostProcessor) {
			link = jsTagPostProcessor.process(link, request)
		}
        link = link.substring(1, link.length() - 1)
		out << link
	}
}
