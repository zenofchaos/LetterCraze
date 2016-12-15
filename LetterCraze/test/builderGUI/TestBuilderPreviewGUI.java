package builderGUI;

import builderControllers.BuilderFileAccessController;
import builderFiles.BuilderLevel;
import builderFiles.BuilderModel;
import junit.framework.TestCase;

public class TestBuilderPreviewGUI extends TestCase{

	BuilderModel model;
	
	@Override
	public void setUp(){
		BuilderFileAccessController FAC = new BuilderFileAccessController();
		try{
			this.model = FAC.getModel();
		}
		catch (Exception e){
			
		}
	}
	
	public void testWindowManipulation(){
		BuilderLevel level = this.model.getMenu().getLevel("P1");
		BuilderPreviewGUI prev = new BuilderPreviewGUI(level);

		prev.openWindow();
		assertEquals(true, prev.isVisible());
		prev.hideWindow();
		assertEquals(false, prev.isVisible());
		
		prev.closeWindow();
		
		level = this.model.getMenu().getLevel("L1");
		prev = new BuilderPreviewGUI(level);

		prev.openWindow();
		assertEquals(true, prev.isVisible());
		prev.hideWindow();
		assertEquals(false, prev.isVisible());
		
		prev.closeWindow();
		
		level = this.model.getMenu().getLevel("T1");
		prev = new BuilderPreviewGUI(level);

		prev.openWindow();
		assertEquals(true, prev.isVisible());
		prev.hideWindow();
		assertEquals(false, prev.isVisible());
		
		prev.closeWindow();
	}
}
