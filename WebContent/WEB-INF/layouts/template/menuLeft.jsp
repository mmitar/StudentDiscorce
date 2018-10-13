

<a href="../login/dashboard" class="logo" style="background: none">
	<svg width="76" height="38" xmlns="http://www.w3.org/2000/svg" xmlns:svg="http://www.w3.org/2000/svg">
	
	  <defs>
	    <linearGradient id="grad2" x1="0%" y1="0%" x2="0%" y2="100%">
	      <stop offset="0%" style="stop-color:rgb(186, 93, 198);stop-opacity:1" />
	      <stop offset="100%" style="stop-color:rgb(210, 124, 221);stop-opacity:1" />
	    </linearGradient>
	  </defs>
	  
	   <rect x="3" y="0" width="71.5" height="35" fill="url(#grad2)"/> <!-- background -->
	 
	   <line stroke="#000000" stroke-width="2" x1="3" x2="3" y1="0" y2="35"/>		<!-- Left -->
	   <line stroke="#000000" stroke-width="2" x1="3" x2="40" y1="1.5" y2="20"/>	<!-- mid left -->
	   <line stroke="#000000" stroke-width="2" x1="39" x2="75" y1="20" y2="2"/>		<!-- mid right -->
	   <line stroke="#000000" stroke-width="2" x1="3" x2="74.5" y1="35" y2="35"/>	<!-- bottom -->
	
	</svg>
</a>

<div class="channels">
	<a style="padding: 0; background: #486593" href="../class/new" class="channel centerFrame">
			<svg width="25" height="25">
				<filter id="dropshadow" width="130%" height="130%">
				  <feGaussianBlur in="SourceAlpha" stdDeviation="3"/> <!-- stdDeviation is how much to blur -->
				  <feOffset dx="3" dy="3" result="offsetblur"/> <!-- how much to offset -->
				  <feComponentTransfer>
				    <feFuncA type="linear" slope="0.5"/> <!-- slope is the opacity of the shadow -->
				  </feComponentTransfer>
				  <feMerge> 
				    <feMergeNode/> <!-- this contains the offset blurred image -->
				    <feMergeNode in="SourceGraphic"/> <!-- this contains the element that the filter is applied to -->
				  </feMerge>
				</filter>
 
				<rect stroke="rgba(0, 0, 0, .4)" stroke-width="1px" fill="#eeeeee" filter="url(#dropshadow)" x="38%" width="7px" height="25px" /> <!-- for shadow -->
				<rect stroke="rgba(0, 0, 0, .4)" fill="#eeeeee" filter="url(#dropshadow)" y="38%" width="25px" height="7px" />
				<rect fill="#eeeeee" x="40%" width="5px" height="23px" />
			</svg>
		
	</a>
	
	<div class="channel placeholder"></div>
	<div class="channel placeholder"></div>
	<div class="channel placeholder"></div>
	
	<div class="channel placeholder"></div>
	<div class="channel placeholder"></div>
	<div class="channel placeholder"></div>
</div>