package ai.other.PailakaDevilsLegacy;

import l2f.gameserver.ai.DefaultAI;
import l2f.gameserver.model.Creature;
import l2f.gameserver.model.instances.NpcInstance;
import l2f.gameserver.tables.SkillTable;

public class PowderKeg extends DefaultAI
{
	public PowderKeg(NpcInstance actor)
	{
		super(actor);
	}

	@Override
	protected void onEvtAttacked(Creature attacker, int damage)
	{
		NpcInstance actor = getActor();
		if (actor == null)
			return;

		actor.setTarget(actor);
		actor.doCast(SkillTable.getInstance().getInfo(5714, 1), attacker, true);
		actor.doDie(null);
		super.onEvtAttacked(attacker, damage);
	}

	@Override
	protected boolean randomWalk()
	{
		return false;
	}

	@Override
	protected boolean randomAnimation()
	{
		return false;
	}
}