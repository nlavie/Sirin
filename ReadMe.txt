ReadMe for Sirin Project:

1)The project contains 3 main components:
	a)Resources.
	b)Graph drawing class.
	c)Main.
2)Resources:
	a)IResource Interface wrapping 3 resources
	b)Resource class implementing the IResource interface.
	c)All resource classes derived from Resource class.
	d)Every resource was implemented as singleton.
	e)Mostly used is the getLastStats method whice brings back list of last amount of stats desired.
3)Graph drawing:
	a)IGUIConfig is an interface configurating graph design.
	b)GuiSideDrawing is a class taking care of all the side painting in the graph frame.
	c)DrawGraph is a class taking care of painting the graph itself - points and lines.
	d)One single class runs it all - RunGraph Class.
4)Main and instructions:
	a)Infinate loop for Infinate graph update.
	b)Update Determined according to SECONDS_TO_UPDATE parameter in Main.
5)In order to add more resource:
	a)Implement Resource Interface.
	b)Create instance of it in Main and add it to ResourceList.
	c)In IGUIConfig interface change:
		1)Change AMOUNT_COLORS parameter to +1.
		2)Add forth(or other number) color definition.
	d)In DrawGraph class:
		1)In Class constructor add the color you created before to colors list.