DashLayout Component
==============================================

NOTE: Project relocated to GitHub: http://github.com/jounikoivuviita/DashLayout

This layout fulfills the following task:

Provide theme designers a more flexible and efficient layout in terms of
margin, border and padding.

And while were at it, why not make it render a bit more faster than the 
core layouts. The DOM structure of this layout is kept mininal, 
only one DIV, inside which child components are places directly.


Known limitations
==============================================

 * Generic component captions are not rendered
 * @import statements in CSS are not traversed for layout details
   - this will be parametrized in future, so you can traverse them for
     individual layouts


Change Log
==============================================

18th Dec 2009
-------------
 * Implemented max/min-width & max/min-height support
   * only pixel values are supported
 * Spacing definitions changed at the same time with min/max sizes
   * Use the following CSS now
   
   	 #v-dashlayout[-stylename]-details {
     	letter-spacing: 10px;  // component spacing
     	min-width: 100px;
     	max-width: 400px;
     	min-height: 100px;
     	max-height: 400px;
     }
     
     or more simply
     
     #stylename-details {
     	...
     }
 
 * Implemented click listener support


20th Nov 2009
-------------
 * 0.1.1 beta
 * 0.1.2 beta (Firefox fix)
 * 0.1.3 beta (Undefined size expand ratio calculation fix)
 

20th Nov 2009
-------------
 * Version 0.1 beta
 * Horizontal version working
 

30th Oct 2009
-------------
 * Refactored the code a bit, unified cell update calculations to one function
 * Spacing handling implemented
   * Spacing can be set via CSS with the following syntax
   
     #v-dashlayout[-stylename]-spacing {
     	width: 10px;
     }
     
     or more simply
     
     #stylename-spacing {
     	width: 10px;
     }

23rd Oct 2009
-------------
 * Fixed a few bugs in expand ratio roundings
 * Renamed component to 'DashLayout', since "Flex" is too vague and can mislead people into Adobe Flex.
   * New project location in Vaadin Incubator is also now "DashLayout"

15th Oct 2009
-------------
 * Refactored FlexLayout to comply with Vaadin 6.2 widgetset compilation
 
 
 
 
 
 
TODO
==============================================

 * Documentation!
 * Firefox 3 sub-pixel rounding errors cause empty space after the components in the layout. Fix by forcing undefined sized components with fractional sizes to integer size.
 * Min-width/min-height fail to inform the parent if the size actually grows bigger than that.
 * Parametrize CSSRule 'deep' parameter (to allow handling of @import rules  for specific layouts
 * Default spacings can't be measured since CSSRule won't look from dashlayout.css (only from Vaadin theme)
   * Workaround is to add default spacing to custom theme
 * Min/max width/height support
 * ClickListeners
 * Implement caption handling