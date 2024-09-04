package megatransparentthespire.patches;

import com.evacipated.cardcrawl.modthespire.lib.SpireInsertPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;

@SpirePatch(cls="com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application", method = "createGlfwWindow", optional = true)
public class LwjglWindowHack
{
    @SpireInsertPatch(rloc=1)
    public static void trans()
    {
        Foo.bar();
    }
}
