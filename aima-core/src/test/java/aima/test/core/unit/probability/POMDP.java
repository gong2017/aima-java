package aima.test.core.unit.probability;

import java.util.HashSet;
import java.util.Set;

/**
 * A concrete implementation of POMDP for testing purposes.
 *
 * @author samagra
 */
public class POMDP implements aima.core.probability.mdp.POMDP {
    double gamma = 1.0;
    State initialState = State.ZERO;

    @Override
    public double getDiscount() {
        return gamma;
    }

    @Override
    public double sensorModel(Object observedState, Object actualState) {
        if (observedState.equals(actualState))
            return 0.9;
        else
            return 0.1;
    }

    @Override
    public Set getAllActions() {
        HashSet<Action> actions = new HashSet<>();
        actions.add(Action.GO);
        actions.add(Action.STAY);
        return actions;
    }

    @Override
    public Set states() {
        HashSet<State> states = new HashSet<>();
        states.add(State.ZERO);
        states.add(State.ONE);
        return states;
    }

    @Override
    public Object getInitialState() {
        return this.initialState;
    }

    @Override
    public Set actions(Object o) {
        return this.getAllActions();
    }

    @Override
    public double transitionProbability(Object sDelta, Object o, aima.core.agent.Action action) {
        if (action.equals(Action.GO)) {
            if (sDelta.equals(o))
                return 0.1;
            else
                return 0.9;
        } else if (action.equals(Action.STAY)) {
            if (sDelta.equals(o))
                return 0.9;
            else
                return 0.1;
        }
        return 0;
    }

    @Override
    public double reward(Object o) {
        if (o.equals(State.ZERO))
            return 0.0;
        else
            return 1.0;
    }

    public enum State {
        ZERO, ONE
    }

    public enum Action implements aima.core.agent.Action {
        GO, STAY;

        @Override
        public boolean isNoOp() {
            return false;
        }
    }
}
