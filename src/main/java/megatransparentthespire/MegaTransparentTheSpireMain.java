package megatransparentthespire;

import basemod.BaseMod;
import basemod.interfaces.*;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.evacipated.cardcrawl.modthespire.Loader;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.IOException;


@SuppressWarnings({"unused", "WeakerAccess"})
@SpireInitializer
public class MegaTransparentTheSpireMain implements PostInitializeSubscriber, PostRenderSubscriber {

    public static String modID = "megatransparentthespire"; //TODO: Change this.
    public static final Logger logger = LogManager.getLogger(modID); //Used to output to the console.

    public static String makeID(String idText) {
        return modID + ":" + idText;
    }

    public MegaTransparentTheSpireMain() {
        BaseMod.subscribe(this);
    }

    public static String makePath(String resourcePath) {
        return modID + "Resources/" + resourcePath;
    }

    public static String makeImagePath(String resourcePath) {
        return modID + "Resources/images/" + resourcePath;
    }

    public static void initialize() {
        MegaTransparentTheSpireMain thismod = new MegaTransparentTheSpireMain();


    }

    @Override
    public void receivePostInitialize() {
        if ((!Loader.LWJGL3_ENABLED))
        {
            Loader.MTS_CONFIG.setBool("imgui", true);
            try {
                Loader.MTS_CONFIG.save();
                Gdx.app.exit();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }


    @Override
    public void receivePostRender(SpriteBatch spriteBatch)
    {

    }
}
