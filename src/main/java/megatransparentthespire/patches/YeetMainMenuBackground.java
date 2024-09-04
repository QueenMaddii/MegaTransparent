package megatransparentthespire.patches;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.evacipated.cardcrawl.modthespire.lib.SpireInstrumentPatch;
import com.evacipated.cardcrawl.modthespire.lib.SpirePatch;
import com.megacrit.cardcrawl.scenes.TitleBackground;
import javassist.CannotCompileException;
import javassist.expr.ExprEditor;
import javassist.expr.FieldAccess;
import megatransparentthespire.util.TextureLoader;

import java.util.ArrayList;
import java.util.List;

import static megatransparentthespire.MegaTransparentTheSpireMain.makeImagePath;

public class YeetMainMenuBackground
{
    @SpirePatch(clz= TitleBackground.class, method=SpirePatch.CONSTRUCTOR)
    public static class YaYeet
    {
        public static TextureAtlas.AtlasRegion get()
        {
            Texture t = TextureLoader.getTexture(makeImagePath("ui/missing.png"));
            return new TextureAtlas.AtlasRegion(t, 0, 0, t.getWidth(), t.getHeight());
        }
        private static final List<String> imagesToYeet = new ArrayList<String>(){{
            add("sky");
            add("mg3Bot");
            add("mg3Top");
            add("topGlow");
            add("topGlow2");
            add("botGlow");
        }};
        @SpireInstrumentPatch
        public static ExprEditor Instrument()
        {
            return new ExprEditor()
            {
                public void edit(FieldAccess f) throws CannotCompileException
                {
                    if (imagesToYeet.stream().anyMatch((String s) -> s.equals(f.getFieldName())))
                    {
                        f.replace("$proceed(megatransparentthespire.patches.YeetMainMenuBackground.YaYeet.get());");
                    }
                }
            };
        }
    }
}