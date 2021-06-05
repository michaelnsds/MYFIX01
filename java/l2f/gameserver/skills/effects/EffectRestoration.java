package l2f.gameserver.skills.effects;

import l2f.gameserver.model.Effect;
import l2f.gameserver.model.Playable;
import l2f.gameserver.stats.Env;
import l2f.gameserver.utils.ItemFunctions;

public class EffectRestoration extends Effect
{
    private final int itemId;
    private final long count;

    public EffectRestoration(Env env, EffectTemplate template)
    {
        super(env, template);
        String item = getTemplate().getParam().getString("Item");
        itemId = Integer.parseInt(item.split(":")[0]);
        count = Long.parseLong(item.split(":")[1]);

    }

    @Override
    public void onStart()
    {
        super.onStart();
        ItemFunctions.addItem((Playable) getEffected(), itemId, count, true, "EffectRestoration");
    }

    @Override
    protected boolean onActionTime()
    {
        return false;
    }
}
